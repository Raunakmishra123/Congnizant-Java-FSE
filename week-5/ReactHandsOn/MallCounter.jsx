import React, { Component } from "react";

class App extends Component {

  constructor() {
    super();

    this.state = {
      e: 0,
      x: 0
    };
  }

  UpdateEntry = () => {
    this.setState({
      e: this.state.e + 1
    });
  };

  UpdateExit = () => {
    this.setState({
      x: this.state.x + 1
    });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h1>Mall Counter</h1>

        <h2>People Entered : {this.state.e}</h2>

        <button onClick={this.UpdateEntry}>
          Login
        </button>

        <br />
        <br />

        <h2>People Exited : {this.state.x}</h2>

        <button onClick={this.UpdateExit}>
          Exit
        </button>
      </div>
    );
  }
}

export default App;