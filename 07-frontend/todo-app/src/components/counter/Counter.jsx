import { useState } from 'react';
import './Counter.css';
import CounterButton from './CounterButton';


export default function Counter(){

    const [total, setTotal= 0] = useState(0);

    function incrementCounterP(by){
        setTotal(total + by)

    }

    function decrementCounterP(by){
        setTotal(total - by)

    }

    function reset(){
        setTotal(0)
    }


    return(
        <div className="Counter">
            <span className="count">{total}</span>
            <div>
                <CounterButton by={1} increment={incrementCounterP} decrement={decrementCounterP}/>
                <CounterButton by={2} increment={incrementCounterP} decrement={decrementCounterP}/>
                <CounterButton by={5} increment={incrementCounterP} decrement={decrementCounterP}/>
            </div>
            <button className="reset" onClick={reset}> Reset </button>
        </div>
    )

}

