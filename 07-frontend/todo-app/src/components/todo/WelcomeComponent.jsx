import { useParams, Link } from "react-router-dom";
import { useState } from "react";
import {retrieveHelloWorldPathVariable } from "./api/HelloWorldAPIService";
import { useAuth } from "./security/AuthContext";


export default function WelcomeComponent(){

    const params = useParams();
    const [message, setMessage] = useState(null);
    const authContext = useAuth();

    function helloRest(){
        retrieveHelloWorldPathVariable(params.username, authContext.token)
        .then( (response) => successResponse(response))
        .catch( (error) => errorResponse(error))
        .finally(() => console.log("Cleanup"));
    }

    function successResponse(response){
        console.log(response);
        setMessage(response.data.message);
    }

    function errorResponse(error){
        console.log(error);
    }

    return(
        <div className="Welcome">
            <h1>Welcome {params.username}</h1>
            <div>
                Manage your todos - Go here <Link to="/todos">Go here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={helloRest}>HelloRest</button>
            </div>
            <div className="text-info"> 
                {message}
            </div>
        </div>
    )
}
