
import FirstComponent from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from "./ThirdComponent";
import ForthComponent from "./ForthComponent";
import {FifthComponent} from './FirstComponent';
import LearningJavascript from './LearningJavascript';
 


export default function LearningComponent() {
  return (
    <div className="LearningComponent">
    
      <FirstComponent/>
      <SecondComponent/>
      <ThirdComponent/>
      <ForthComponent/>
      <FifthComponent />
      <LearningJavascript />

    </div>
  );
}

