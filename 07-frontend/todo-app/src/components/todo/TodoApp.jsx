
import { useState } from 'react';
import './TodoApp.css';
import {BrowserRouter, Routes, Route, useNavigate, useParams, Link, Navigate} from 'react-router-dom';
import HeaderComponent from './HeaderComponent';
import FooterComponent from './FooterComponent';
import WelcomeComponent from './WelcomeComponent';
import LogoutComponent from './LogoutComponent';
import ListTodosComponent from './ListTodosComponent';
import LoginComponent from  './LoginComponent';
import ErrorComponent from './ErrorComponent';
import AuthProvider from './security/AuthContext';
import {useAuth} from './security/AuthContext';


function AuthenticatedRoute({children}){
    const authContext = useAuth();

    if(authContext.isAuthenticated)
        return children;
    return <Navigate to="/" />
}

export default function TodoApp(){

    return(
        <div className="TodoApp">
            {/* <h1>Todo Management Application</h1> */}
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/" element={<LoginComponent />} />
                        <Route path="/login" element={<LoginComponent />} />
                        <Route path="/welcome/:username" element={
                           <AuthenticatedRoute> <WelcomeComponent /> </AuthenticatedRoute> 
                        }/>

                        <Route path="/todos" element={
                            <AuthenticatedRoute> <ListTodosComponent /> </AuthenticatedRoute> 
                        }/>
                        <Route path="/logout" element={
                            <AuthenticatedRoute> <LogoutComponent /> </AuthenticatedRoute>
                        }/>
                        <Route path="*" element={<ErrorComponent />} />
                        
                    </Routes>
                    <FooterComponent/>
                </BrowserRouter>
            </AuthProvider>
            
            
        </div>
    )
}



