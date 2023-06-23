import {Component} from "react";
import './App.css';
import Counter from './components/counter/Counter';
import TodoApp from "./components/todo/TodoApp";


function App() {
  return (
    <div className="App">
      {/* <Counter /> */}
      <TodoApp />
    </div>
  );
}


export default App;
