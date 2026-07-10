import React from "react";

function CalculateScore() {
  let n = "AK";
  let s = "LPU";
  let t = 480;
  let g = 6;

  let a = t / g;

  return (
    <div style={{ textAlign: "center", marginTop: "40px" }}>
      <h1>Student Score Calculator</h1>

      <h3>Name : {n}</h3>
      <h3>School : {s}</h3>
      <h3>Total Marks : {t}</h3>
      <h3>Subjects : {g}</h3>
      <h2>Average : {a}</h2>
    </div>
  );
}

function App() {
  return (
    <div>
      <CalculateScore />
    </div>
  );
}

export default App;