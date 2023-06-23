
import { useState } from 'react';
import './TodoApp.css';
import {BrowserRouter, Routes, Route, useNavigate, useParams, Link} from 'react-router-dom';


export default function TodoApp(){

    return(
        <div className="TodoApp">
            {/* <h1>Todo Management Application</h1> */}
            <HeaderComponent/>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="/login" element={<LoginComponent />} />
                    <Route path="/welcome/:username" element={<WelcomeComponent />} />
                    <Route path="/todos" element={<ListTodosComponent />} />
                    <Route path="/logout" element={<LogoutComponent />} />
                    <Route path="*" element={<ErrorComponent />} />
                    
                </Routes>
            </BrowserRouter>
            <FooterComponent/>
            
        </div>
    )
}

function LoginComponent(){
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

function WelcomeComponent(){

    const params = useParams();


    return(
        <div className="Welcome">
            <h1>Welcome {params.username}</h1>
            <div>
                Manage your todos - Go here <Link to="/todos">Go here</Link>
            </div>
        </div>
    )
}

function ErrorComponent(){
    return(
        <div className="ErrorComponent">
            <h1>We are really working hard!</h1>
            <div>
                Apologies for the 404. Reach out to our team SRE. 
            </div>
        </div>
    )
}

function ListTodosComponent(){

    const today = new Date();
    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay());

    const todos = [
        {id:1, description:"Learn AWS", done: false, targetDate: targetDate},
        {id:2, description:"Learn Kafka", done: false, targetDate: targetDate},
        {id:3, description:"Learn Kubernetes", done: false, targetDate: targetDate}
    ];

    return(
        <div className="ListTodosComponent">
            <h1> Things you want to do!</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>Id</td> 
                            <td>Description</td>
                            <td>Is Done? </td>
                            <td>Target Date </td>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            todos.map(
                                todo =>(
                                    <tr key={todo.id} >
                                        <td>{todo.id}</td> 
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate.toDateString()}</td>
                                    </tr>
                                )
                            )
                        }
                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}


function HeaderComponent(){
    return(
        <div className="Header">
            Header <hr/>
        </div>
    )
}

function FooterComponent(){
    return(
        <div className="Footer">
           <hr/> Footer 
        </div>
    )
}

function LogoutComponent(){
    return(
        <div className="LogoutComponent">
            <h1>You are logged out!</h1>
            <div>
                Thank you for using our App. Come back soon! 
            </div>
        </div>
    )
}

