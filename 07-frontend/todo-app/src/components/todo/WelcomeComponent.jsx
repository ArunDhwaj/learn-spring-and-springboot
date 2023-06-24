import { useParams, Link } from "react-router-dom";
import axios from 'axios';


export default function WelcomeComponent(){

    const params = useParams();
    function helloRest(){
        axios.get('http://localhost:8080/hello-world')
        .then( (response) => successResponse(response))
        .catch( (error) => errorResponse(error))
        .finally(() => console.log("Cleanup"))
    }

    function successResponse(response){
        console.log(response);
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
        </div>
    )
}
