
const person ={
  name: 'SBP',
  address:{
    line1: 'E City',
    city: 'Bangalore',
    country: 'India'
  },
  profiles: ['LinkedIn', 'Twitter'],

  printProfile: ()=>{

    person.profiles.map( (profile) => {
      console.log(profile);
    })
    
  }
}

export default function LearningJavascript(){
  
    return(
      <div>
        <div className="LearningJavascript"> {person.nane} </div>
        <div className="LearningJavascript"> {person.address.line1} </div>
        <div className="LearningJavascript"> {person.address.city} </div>
        <div className="LearningJavascript"> {person.address.country} </div>
        <div className="LearningJavascript"> {person.profiles[0]} </div>
        <div className="LearningJavascript"> {person.printProfile()} </div>

      </div>
    )
  }
