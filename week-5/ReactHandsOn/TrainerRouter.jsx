import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  useParams
} from "react-router-dom";

const a = [
  {
    id: 1,
    name: "Rahul",
    phone: "9876543210",
    email: "rahul@gmail.com",
    tech: "React",
    skills: "JS, HTML, CSS"
  },
  {
    id: 2,
    name: "Anil",
    phone: "9876543211",
    email: "anil@gmail.com",
    tech: "Java",
    skills: "Core Java, Spring"
  },
  {
    id: 3,
    name: "Kiran",
    phone: "9876543212",
    email: "kiran@gmail.com",
    tech: "Python",
    skills: "Python, Django"
  }
];

function Home() {
  return (
    <div>
      <h2>Welcome to Trainers App</h2>
      <p>This is Home Page.</p>
    </div>
  );
}

function Trainers() {
  return (
    <div>
      <h2>Trainer List</h2>

      <ul>
        {a.map((x) => (
          <li key={x.id}>
            <Link to={"/trainer/" + x.id}>{x.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

function Details() {
  const { id } = useParams();

  const x = a.find((i) => i.id === Number(id));

  if (!x) {
    return <h2>Trainer Not Found</h2>;
  }

  return (
    <div>
      <h2>Trainer Details</h2>

      <p><b>ID :</b> {x.id}</p>

      <p><b>Name :</b> {x.name}</p>

      <p><b>Phone :</b> {x.phone}</p>

      <p><b>Email :</b> {x.email}</p>

      <p><b>Technology :</b> {x.tech}</p>

      <p><b>Skills :</b> {x.skills}</p>
    </div>
  );
}

function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: "20px" }}>
        <h1>Trainer Management</h1>

        <Link to="/">Home</Link>

        {" | "}

        <Link to="/trainers">Trainers</Link>

        <hr />

        <Routes>
          <Route path="/" element={<Home />} />

          <Route path="/trainers" element={<Trainers />} />

          <Route path="/trainer/:id" element={<Details />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;