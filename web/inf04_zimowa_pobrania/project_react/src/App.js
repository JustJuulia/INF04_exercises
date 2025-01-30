import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

const data = [
  { id: 0, alt: "Mak", filename: "obraz1.jpg", category: 1, downloads: 35 },
  { id: 1, alt: "Bukiet", filename: "obraz2.jpg", category: 1, downloads: 43 },
  {
    id: 2,
    alt: "Dalmatyńczyk",
    filename: "obraz3.jpg",
    category: 2,
    downloads: 2,
  },
  {
    id: 3,
    alt: "Świnka morska",
    filename: "obraz4.jpg",
    category: 2,
    downloads: 53,
  },
  {
    id: 4,
    alt: "Rotwailer",
    filename: "obraz5.jpg",
    category: 2,
    downloads: 43,
  },
  { id: 5, alt: "Audi", filename: "obraz6.jpg", category: 3, downloads: 11 },
  { id: 6, alt: "kotki", filename: "obraz7.jpg", category: 2, downloads: 22 },
  { id: 7, alt: "Róża", filename: "obraz8.jpg", category: 1, downloads: 33 },
  {
    id: 8,
    alt: "Świnka morska",
    filename: "obraz9.jpg",
    category: 2,
    downloads: 123,
  },
  {
    id: 9,
    alt: "Foksterier",
    filename: "obraz10.jpg",
    category: 2,
    downloads: 22,
  },
  {
    id: 10,
    alt: "Szczeniak",
    filename: "obraz11.jpg",
    category: 2,
    downloads: 12,
  },
  {
    id: 11,
    alt: "Garbus",
    filename: "obraz12.jpg",
    category: 3,
    downloads: 321,
  },
];

const Tile = ({ imgSrc, downloads, imgAlt }) => {
  const [count, setCout] = useState(downloads);

  const handle_button = () => {
    setCout(count + 1);
  };

  return (
    <div>
      <img src={imgSrc} alt={imgAlt} />
      <div>
        <div>Pobrań: {count}</div>
        <input
          className={"btn btn-success"}
          value={"Pobierz"}
          type="button"
          onClick={handle_button}
        />
      </div>
    </div>
  );
};

function App() {
  const [kwiaty, setKwiaty] = useState(true);
  const [zwierzeta, setZwierzeta] = useState(true);
  const [samochody, setSamochody] = useState(true);

  return (
    <div>
      <div>Kategorie zdjęć</div>
      <div>
        <input
          className="form-check-input"
          type="checkbox"
          defaultChecked={kwiaty}
          onChange={() => {
            setKwiaty(!kwiaty);
          }}
        />{" "}
        Kwiaty
        <input
          className="form-check-input"
          type="checkbox"
          defaultChecked={zwierzeta}
          onChange={() => {
            setZwierzeta(!zwierzeta);
          }}
        />{" "}
        Zwierzęta
        <input
          className="form-check-input"
          type="checkbox"
          defaultChecked={samochody}
          onChange={() => {
            setSamochody(!samochody);
          }}
        />{" "}
        Samochody
      </div>
      {data.map((element, index) => {
        if (!kwiaty && element.category === 1) {
          return null;
        }
        if (!zwierzeta && element.category === 2) {
          return null;
        }
        if (!samochody && element.category === 3) {
          return null;
        }

        const filename = `assets/` + element.filename;
        return (
          <Tile
            key={element.id}
            imgAlt={element.alt}
            imgSrc={filename}
            downloads={element.downloads}
          />
        );
      })}
    </div>
  );
}

export default App;
