import React from "react";

function App() {
  let a = [
    {
      code: "INTADMDF10",
      name: "React Training",
      status: "Ongoing",
      coach: "Rahul",
      trainer: "Anil"
    },
    {
      code: "INTADMDF11",
      name: "Java Training",
      status: "Completed",
      coach: "Ravi",
      trainer: "Kiran"
    },
    {
      code: "INTADMDF12",
      name: "Python Training",
      status: "Ongoing",
      coach: "Amit",
      trainer: "Ramesh"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h1>Cohort Details</h1>

      {a.map((x, i) => (
        <div
          key={i}
          style={{
            width: "300px",
            display: "inline-block",
            margin: "10px",
            padding: "10px 20px",
            border: "1px solid black",
            borderRadius: "10px"
          }}
        >
          <h3
            style={{
              color: x.status === "Ongoing" ? "green" : "blue"
            }}
          >
            {x.code}
          </h3>

          <p><b>Course :</b> {x.name}</p>
          <p><b>Status :</b> {x.status}</p>
          <p><b>Coach :</b> {x.coach}</p>
          <p><b>Trainer :</b> {x.trainer}</p>
        </div>
      ))}
    </div>
  );
}

export default App;