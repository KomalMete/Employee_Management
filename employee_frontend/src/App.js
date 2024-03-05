import logo from './logo.svg';
import './App.css';
import AdminHome from './Component/AdminHome';
import AddDepartment from './Component/AddDepartment';
import { BrowserRouter as Router, Routes, Route, BrowserRouter } from 'react-router-dom';
import AdminNavbar from './Component/AdminNavbar';
import EmployeeNavbar from './Component/EmployeeNavbar';
import Login from './Component/Login';
import Register from './Component/Register';

function App() {
  return (
    <div className="App">

        <BrowserRouter>
            <Routes>
              <Route path="/adddept" element={<AddDepartment />}/>
              <Route path="/adminhome" element={<AdminHome />}/>
              <Route path="/dept/getdept/:id" element={<AddDepartment />}/>
              <Route path="/login" element={<Login />}/>
              <Route path="/" element={<Register />}/>
            </Routes>
        </BrowserRouter>

        
    </div>
  );
}

export default App;
