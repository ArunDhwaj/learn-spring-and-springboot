import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/HelloWorldAPIService";
import { apiClient } from "../api/ApiClient";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);


export default function AuthProvider({children}){

    const [isAuthenticated, setAuthenticated] = useState(false); 
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);


    async function login(username, password){

        const baToken = 'Basic ' + window.btoa(username + ":" + password)
       
        try{
            const response = await executeBasicAuthenticationService(baToken)
        
            if(response.status == 200){
                setAuthenticated(true);
                setUsername(username);
                setToken(baToken);

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log("Intercepting and adding a token");
                        config.headers.Authorization = baToken;
                        return config;
                    }
                )
                return true;
            }
            else{
                logout();
                return false;
            }
        }
        catch(error)
        {
            logout();
        }
    }

    function logout(){
        setAuthenticated(false);
        setUsername(null);
        setToken(null);
    }

    return(
        <AuthContext.Provider value={{isAuthenticated, setAuthenticated, login, logout, username, token}} >
            {children}
        </AuthContext.Provider>
    )
}