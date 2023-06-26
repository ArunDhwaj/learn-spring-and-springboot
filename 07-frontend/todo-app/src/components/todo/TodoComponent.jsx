import { useEffect, useState } from "react";
import { useParams, useNavigate} from "react-router-dom";
import {retrieveTodoApi, putTodoApi, createTodoApi} from './api/TodoAPIService';
import { useAuth } from "./security/AuthContext";
import {Formik, Form, Field, ErrorMessage} from 'formik';
import moment from 'moment';


export default function TodoComponent(){
    const {id} = useParams();
    
    const authContext = useAuth();
    const username = authContext.username;
    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');
    const navigate = useNavigate();

    useEffect(  
        ()=> retrieveTodo(),
        [id]
    )

    function retrieveTodo(){

        if(id != -1)
            {
            retrieveTodoApi(username, id)
            .then(
                response => {
                    console.log(response.data);
                    setDescription(response.data.description);
                    setTargetDate(response.data.targetDate);
                }
            )
            .catch(
                error => {console.log(error);
                }
            )
        }
    }

    function onSubmit(values){

        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        } 

        if(id != -1){
            putTodoApi(username, id, todo)
            .then(
                response => {
                    // console.log(response);
                    navigate('/todos');
                }
            )
            .catch(
                error => {console.log(error);
                }
            )
        }
        else
        {
            createTodoApi(username, todo)
            .then(
                response => {
                    // console.log(response);
                    navigate('/todos');
                }
            )
            .catch(
                error => {console.log(error);
                }
            )
        }

        // //console.log(values);
    }

    function validate(values){
        let errors = {
            // description: 'Enter a valid description',
            // targetDate: 'Enter a valid target date'
        }

        if(values.description.length < 5){
            errors.description ="Description will be at least 5 characters"
        }

        if( (values.targetDate==null) || (values.targetDate == '') || (! moment(values.targetDate).isValid()) ){
            errors.targetDate ="Enter a valid target date"
        }

        if(moment() > moment(values.targetDate)){
            errors.targetDate ="Target date should be in future"
        }

        console.log("validate: ");
        console.log(values);
        return errors;
    }

    return(
        <div className="container">
            <h1>Enter todo details</h1>
             Description: {description}
            <div>
                <Formik initialValues={{description, targetDate}} enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                {
                    (props) => (
                        <Form>
                            <ErrorMessage
                                name="description"
                                component="div"
                                className="alert alert-warning"
                            />

                            <ErrorMessage
                                name="targetDate"
                                component="div"
                                className="alert alert-warning"
                            />

                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field type="text" className="form-control" name="description" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field type="date" className="form-control" name="targetDate" />
                            </fieldset>
                            <div>
                                <button className="btn btn-success m-5" type="submit">save</button>
                            </div>
                        </Form>
                    )
                }
                </Formik>
            </div>
        </div>
    )
}