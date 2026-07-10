import React from "react";

function Home() {
  return (
    <div>
      <h2>Welcome to the Home page of Student Management Portal</h2>
    </div>
  );
}

function About() {
  return (
    <div>
      <h2>Welcome to the About page of Student Management Portal</h2>
    </div>
  );
}

function Contact() {
  return (
    <div>
      <h2>Welcome to the Contact page of Student Management Portal</h2>
    </div>
  );
}

function App() {
  return (
    <div>
      <h1>Student Management Portal</h1>

      <Home />

      <About />

      <Contact />
    </div>
  );
}

export default App;