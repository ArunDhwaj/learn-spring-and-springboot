import {Component} from "react";


import './App.css';

import Counter from './components/counter/Counter';


function App() {
  return (
    <div className="App">
     <h1> My Todo Application </h1> 
      <br/>
      <Counter />
    </div>
  );
}


export default App;
