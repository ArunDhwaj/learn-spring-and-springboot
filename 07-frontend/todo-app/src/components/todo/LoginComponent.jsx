import { useState } from 'react';
import {useNavigate} from 'react-router-dom';


export default function LoginComponent(){
    const [username, setUsername] = useState("SBP");
    const [password, setPassword] = useState("");

    const [successM, setSuccessM] = useState(false);
    const [errorM, setErrorM] = useState(false);
    const navigate = useNavigate();


    function handleSubmit(){
        if(username==="SBP" && password==="admin"){
            setSuccessM(true);
            setErrorM(false);
            navigate(`/welcome/${username}`);
        }
        else{
            setSuccessM(false);
            setErrorM(true);
        }
    }

    return(
        <div className="Login">
            <h1>Time to Login</h1>

           {successM &&  <div className='successMessage'> Authenticated Successfully</div>}
           {errorM && <div className='errorMessage'> Authenticated Failed. Please check your credential.</div>}

            <div className="LoginForm">
                <div>
                    <label>Username</label>
                    <input type="text" name="username"  value={username} onChange={(event)=>setUsername(event.target.value)}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={(event)=>setPassword(event.target.value)}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}
