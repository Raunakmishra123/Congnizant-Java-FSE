import React from "react";

function App() {

  let a = {
    name:"ABC Tower",
    rent:75000,
    address:"Hyderabad"
  };

  let b = [
    {
      name:"ABC Tower",
      rent:75000,
      address:"Hyderabad"
    },
    {
      name:"XYZ Plaza",
      rent:45000,
      address:"Bangalore"
    },
    {
      name:"Tech Park",
      rent:90000,
      address:"Chennai"
    }
  ];

  return (
    <div style={{padding:"20px"}}>

      <h1>Office Space Rental App</h1>

      <img
        src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=600"
        width="400"
        alt="office"
      />

      <h2>Single Office</h2>

      <p><b>Name :</b> {a.name}</p>

      <p
        style={{
          color:a.rent<60000?"red":"green"
        }}
      >
        <b>Rent :</b> {a.rent}
      </p>

      <p><b>Address :</b> {a.address}</p>

      <hr/>

      <h2>Office List</h2>

      {b.map((x,i)=>(

        <div
          key={i}
          style={{
            border:"1px solid black",
            padding:"10px",
            margin:"10px",
            width:"300px"
          }}
        >

          <h3>{x.name}</h3>

          <p
            style={{
              color:x.rent<60000?"red":"green"
            }}
          >
            Rent : {x.rent}
          </p>

          <p>Address : {x.address}</p>

        </div>

      ))}

    </div>
  );
}

export default App;