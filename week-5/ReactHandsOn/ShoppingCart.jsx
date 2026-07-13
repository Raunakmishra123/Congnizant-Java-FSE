import React from "react";

function Cart(p) {
  return (
    <div
      style={{
        border: "1px solid black",
        margin: "10px",
        padding: "10px",
        borderRadius: "10px",
        width: "250px"
      }}
    >
      <h3>{p.name}</h3>
      <h4>Price : ₹{p.price}</h4>
    </div>
  );
}

function App() {
  let a = [
    { name: "Laptop", price: 65000 },
    { name: "Mobile", price: 25000 },
    { name: "Headphones", price: 3000 },
    { name: "Keyboard", price: 1500 },
    { name: "Mouse", price: 800 }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h1>Online Shopping</h1>

      {a.map((x, i) => (
        <Cart
          key={i}
          name={x.name}
          price={x.price}
        />
      ))}
    </div>
  );
}

export default App;