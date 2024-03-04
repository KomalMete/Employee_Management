import logo from './logo.svg';
import './App.css';
import AdminHome from './Component/AdminHome';
import AddDepartment from './Component/AddDepartment';
import { BrowserRouter as Router, Routes, Route, BrowserRouter } from 'react-router-dom';
function App() {
  return (
    <div className="App">

        <BrowserRouter>
            <Routes>
              <Route path="/" element={<AddDepartment />}/>
              <Route path="/adminhome" element={<AdminHome />}/>
            </Routes>
        </BrowserRouter>

        
    </div>
  );
}

export default App;
