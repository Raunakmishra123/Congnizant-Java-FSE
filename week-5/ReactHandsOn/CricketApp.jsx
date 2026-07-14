import React from "react";

function App() {

  let a = [
    {name:"Virat",score:95},
    {name:"Rohit",score:65},
    {name:"Gill",score:88},
    {name:"Rahul",score:45},
    {name:"Pant",score:76},
    {name:"Hardik",score:55},
    {name:"Jadeja",score:92},
    {name:"Ashwin",score:60},
    {name:"Shami",score:40},
    {name:"Bumrah",score:98},
    {name:"Siraj",score:72}
  ];

  let low = a.filter(x => x.score < 70);

  let odd = ["Virat","Gill","Pant","Jadeja","Shami","Siraj"];
  let even = ["Rohit","Rahul","Hardik","Ashwin","Bumrah"];

  let t20 = ["Virat","Rohit","Gill"];
  let ranji = ["Pujara","Rahane","Mayank"];

  let all = [...t20,...ranji];

  let f = true;

  return (
    <div style={{padding:"20px"}}>

      <h1>Cricket App</h1>

      {f ? (

        <div>

          <h2>All Players</h2>

          {a.map((x,i)=>(
            <p key={i}>
              {x.name} - {x.score}
            </p>
          ))}

          <h2>Players Below 70</h2>

          {low.map((x,i)=>(
            <p key={i}>
              {x.name} - {x.score}
            </p>
          ))}

        </div>

      ) : (

        <div>

          <h2>Odd Team</h2>

          {odd.map((x,i)=>(
            <p key={i}>{x}</p>
          ))}

          <h2>Even Team</h2>

          {even.map((x,i)=>(
            <p key={i}>{x}</p>
          ))}

          <h2>Merged Players</h2>

          {all.map((x,i)=>(
            <p key={i}>{x}</p>
          ))}

        </div>

      )}

    </div>
  );
}

export default App;