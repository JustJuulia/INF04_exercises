import logo from "./logo.svg";
import "./App.css";
import { React, useState } from "react";

function App() {
  const data = {
    beer: [
      "./beer/01.png",
      "./beer/02.png",
      "./beer/03.png",
      "./beer/04.png",
      "./beer/05.png",
      "./beer/06.png",
      "./beer/07.png",
      "./beer/08.png",
    ],
    fruit: [
      "./fruit/1.png",
      "./fruit/10.png",
      "./fruit/11.png",
      "./fruit/13.png",
      "./fruit/26.png",
      "./fruit/36.png",
      "./fruit/4.png",
      "./fruit/8.png",
    ],
    herb: [
      "./herb/1.png",
      "./herb/13.png",
      "./herb/15.png",
      "./herb/28.png",
      "./herb/29.png",
      "./herb/37.png",
      "./herb/7.png",
      "./herb/9.png",
    ],
    undead: [
      "./undead/1.png",
      "./undead/10.png",
      "./undead/13.png",
      "./undead/14.png",
      "./undead/26.png",
      "./undead/38.png",
      "./undead/4.png",
      "./undead/45.png",
    ],
    vegetable: [
      "./vegetable/1.png",
      "./vegetable/15.png",
      "./vegetable/20.png",
      "./vegetable/22.png",
      "./vegetable/27.png",
      "./vegetable/41.png",
      "./vegetable/5.png",
      "./vegetable/9.png",
    ],
  };

  const BeerComponent = ({ url }) => {
    const number = url.split("/")[2].split(".")[0];
    const [isFoam, setFoam] = useState(false);
    const foam_pic = "./beer/" + number + "_foam.png";
    return (
      <>
        <div class="card" style={{ width: "18rem" }}>
          <img
            class="card-img-top"
            src={!isFoam ? url : foam_pic}
            alt="Card image cap"
          />
          <div class="card-body">
            <h5 class="card-title">beer: {number}</h5>
            <p class="card-text">This is a beer</p>
            <button class="btn btn-primary" onClick={() => setFoam(!isFoam)}>
              {!isFoam ? <p>Fill</p> : <p>Drink</p>}
            </button>
          </div>
        </div>
      </>
    );
  };
  const keys = Object.keys(data);
  return (
    <>
      {keys.map((key) => {
        const urls = data[key];
        if (key === "beer") {
          return urls.map((url) => {
            return( <BeerComponent url={url} /> );
          });
        } else {
        }
      })}
    </>
  );
}

export default App;
