import React, { Component } from "react";

class App extends Component {
  constructor() {
    super();

    this.state = {
      a: []
    };
  }

  componentDidMount() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((r) => r.json())
      .then((d) => {
        this.setState({ a: d.slice(0, 10) });
      });
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>Blog Posts</h1>

        {this.state.a.map((x) => (
          <div
            key={x.id}
            style={{
              border: "1px solid black",
              padding: "10px",
              marginBottom: "10px"
            }}
          >
            <h3>{x.title}</h3>
            <p>{x.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default App;