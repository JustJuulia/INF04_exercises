import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const [tablica, setTablica] = useState([
    { id: 0, alt: "Mak", filename: "obraz1.jpg", category: 1, downloads: 35 },
    { id: 1, alt: "Bukiet", filename: "obraz2.jpg", category: 1, downloads: 43 },
    { id: 2, alt: "Dalmatyńczyk", filename: "obraz3.jpg", category: 2, downloads: 2 },
    { id: 3, alt: "Świnka morska", filename: "obraz4.jpg", category: 2, downloads: 53 },
    { id: 4, alt: "Rotwailer", filename: "obraz5.jpg", category: 2, downloads: 43 },
    { id: 5, alt: "Audi", filename: "obraz6.jpg", category: 3, downloads: 11 },
    { id: 6, alt: "kotki", filename: "obraz7.jpg", category: 2, downloads: 22 },
    { id: 7, alt: "Róża", filename: "obraz8.jpg", category: 1, downloads: 33 },
    { id: 8, alt: "Świnka morska", filename: "obraz9.jpg", category: 2, downloads: 123 },
    { id: 9, alt: "Foksterier", filename: "obraz10.jpg", category: 2, downloads: 22 },
    { id: 10, alt: "Szczeniak", filename: "obraz11.jpg", category: 2, downloads: 12 },
    { id: 11, alt: "Garbus", filename: "obraz12.jpg", category: 3, downloads: 321 }
  ]);
  
  const [kwiatki, setKwiatki] = useState(true);
  const [zwierzaczki, setZwierzaczki] = useState(true);
  const [autka, setAutka] = useState(true);

  const kwiatkiChange = () => {
    setKwiatki(prev => !prev);
  };

  const autaChange = () => {
    setAutka(prev => !prev);
  };

  const zwierzakiChange = () => {
    setZwierzaczki(prev => !prev);
  };
  const incrementDownloads = (id) => {
    setTablica(prevTablica => prevTablica.map(tab => 
      tab.id === id ? { ...tab, downloads: tab.downloads + 1 } : tab
    ));
  };

  return (
    <>
      <h3>Kategorie zdjęć</h3>
      <div className='d-flex'>
        <div class="form-check form-switch">
          <input
            class="form-check-input kwiaty"
            type="checkbox"
            role="switch"
            id="kwiaty"
            checked={kwiatki}
            onChange={kwiatkiChange}
          />
          <label class="form-check-label" htmlFor="kwiaty">Kwiaty</label>
        </div>
        <div class="form-check form-switch">
          <input
            class="form-check-input zwierzeta"
            type="checkbox"
            role="switch"
            id="zwierzeta"
            checked={zwierzaczki}
            onChange={zwierzakiChange}
          />
          <label class="form-check-label" htmlFor="zwierzeta">Zwierzęta</label>
        </div>
        <div class="form-check form-switch">
          <input
            class="form-check-input samochody"
            type="checkbox"
            role="switch"
            id="samochody"
            checked={autka}
            onChange={autaChange}
          />
          <label class="form-check-label" htmlFor="samochody">Samochody</label>
        </div>
      </div>
      <div className='d-flex flex-wrap gap-5 wszystko'>
        {tablica.map((tab) => (
          <div key={tab.id} className='zdjecia'>
            <div>
              {((tab.category === 1 && kwiatki) || 
                (tab.category === 2 && zwierzaczki) || 
                (tab.category === 3 && autka)) && (
                <div>
                  <img src={`./${tab.filename}`} alt={tab.alt} />
                  <p>Liczba pobran: {tab.downloads}</p>
                  <div className='btn btn-success'>
                    <a 
                      href={`./${tab.filename}`} 
                      download 
                      className='text-white'
                      onClick={() => incrementDownloads(tab.id)}
                    >
                      Pobierz
                    </a>
                  </div>
                </div>
              )}
            </div>
          </div>
        ))}
      </div>
    </>
  );
}

export default App;