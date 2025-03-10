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
  const OtherCategories = ({ url, firstVowel }) => {
    const number = url.split("/")[2].split(".")[0];
    const name = url.split("/")[1];
    let [counter, addCounter] = useState(0);
    return (<>
    <div class="card" style={{ width: "18rem" }}>
          <img
            class="card-img-top"
            src={url}
            alt="Card image cap"
          />
          <div class="card-body">
            <h5 class="card-title">{name}: {number}</h5>
            <p class="card-text">This is {firstVowel ? 'an' : 'a'} {name}</p>
            <button class="btn btn-primary" onClick={() => addCounter(counter + 1)}>
              Click me! <span class="badge badge-secondary text-bg-secondary">{counter}</span>
            </button>
          </div>
        </div>
    </>)
  }
  const keys = Object.keys(data);
  const [pickedBeer, setBeer] = useState(true);
  const [pickedFruit, setFruit] = useState(true);
  const [pickedHerb, setHerb] = useState(true);
  const [pickedUndead, setUndead] = useState(true);
  const [pickedVegetable, setVegetable] = useState(true);
  return (
    <>
    <div class="d-flex">
    <div class="form-check form-switch">
      <input class="form-check-input ml-2" type="checkbox" role="switch" id="flexSwitchCheckChecked" defaultChecked={pickedBeer} onClick={() => setBeer(!pickedBeer)}/>
      <label class="form-check-label" for="flexSwitchCheckChecked"> Beer </label>
    </div>
    <div class="form-check form-switch ml-2">
      <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" defaultChecked={pickedFruit} onClick={() => setFruit(!pickedFruit)}/>
      <label class="form-check-label" for="flexSwitchCheckChecked"> Fruit </label>
    </div>
    <div class="form-check form-switch ml-2">
      <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" defaultChecked={pickedBeer} onClick={() => setHerb(!pickedHerb)}/>
      <label class="form-check-label" for="flexSwitchCheckChecked"> Herb </label>
    </div>
    <div class="form-check form-switch ml-2">
      <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" defaultChecked={pickedBeer} onClick={() => setUndead(!pickedUndead)}/>
      <label class="form-check-label" for="flexSwitchCheckChecked"> Undead </label>
    </div>
    <div class="form-check form-switch ml-2">
      <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" defaultChecked={pickedBeer} onClick={() => setVegetable(!pickedVegetable)}/>
      <label class="form-check-label" for="flexSwitchCheckChecked"> Vegetable </label>
    </div>
    </div>
    <div class="d-flex row">
      {keys.map((key) => {
        const urls = data[key];
        if((key === "beer" && pickedBeer) || (key === "fruit" && pickedFruit) || (key === "herb" && pickedHerb) || (key === "undead" && pickedUndead) || (key === "vegetable" && pickedVegetable)){
        if (key === "beer") {
          return urls.map((url) => {
            return( <BeerComponent url={url} /> );
          });
        } else {
          if(key[0] === "a" || key[0] === "e" || key[0] === "i" || key[0] === "o" || key[0] === "u" ){
            return urls.map((url) => {
              return( <OtherCategories url={url} firstVowel={true}/> );
            });
          }
          else{
            return urls.map((url) => {
              return( <OtherCategories url={url} firstVowel={false}/> );
            });
          }
        }
      }
      else{
        return null;
      }
      })}
      </div>
    </>
  );
}

export default App;
