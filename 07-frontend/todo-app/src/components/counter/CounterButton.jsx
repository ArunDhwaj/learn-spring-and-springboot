import { PropTypes } from "prop-types";
import './CounterButton.css';


export default function CounterButton({by, increment,decrement}){


    return(
        <div className="CounterButton">
        
            <div className='child'>
                <button className="actionButton" onClick={()=> increment(by)}> +{by} </button>
            </div>
            <div className='child'>
                <button className="actionButton" onClick={()=> decrement(by)}> -{by} </button>
            </div>


        </div>
    );
}


CounterButton.propTypes = {
    by: PropTypes.number
  }
  
CounterButton.defaultProps = {
    by: 1
  }
  