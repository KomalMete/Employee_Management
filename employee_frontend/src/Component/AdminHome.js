import React from 'react';
import { Link } from "react-router-dom";
import axios from "axios";
import { useEffect, useState } from "react";
import './AdminHome.css';
import './AddDepartment.css'
import { useNavigate } from "react-router-dom";

const AdminHome =() =>{

    const[depts, setDept] = useState([]);
    const navigate = useNavigate();
    const HandleDelete=(id)=>{
        axios.delete("http://localhost:8080"+"/dept/remove/"+id)
        .then(response =>{
            console.log("printing data")
            init();
        })
        .catch(error => {
            console.log('Something went wrong', error);
        })
    }

    useEffect(() => {
        init();
    }, []);

    const init =()=>{

        axios.get("http://localhost:8080"+"/dept")
        .then(response =>{
            setDept(response.data);
        })
        .catch(error => {
            console.log('Something went wrong', error);
        });
    }

    return(
        <div>
            <h1>Department details</h1>
            <div className='container'>

            
            <div className='row'>
                <div className="col">

                </div>
                <div className="col">
                    <Link className="btn btn-primary" to={"/adddept"}>Add Department</Link>
                </div>
            </div>
            
            <table className="col-6 mx-6 my-4 offset-2 border-2 bts">
                    <thead>
                        <tr>
                        <th className="col-2">ID</th>
                        <th className="col-4">Department Name</th>
                       
                        </tr>
                    </thead>
                    {depts.map((item) => (
                    <tbody key={item.id}>
                        <td className="col-2">{item.id}</td>
                        <td className="col-4">{item.deptName}</td>
                        <td className="col-2"><button  type="button" className="btn btn-success" onClick={()=>{navigate(`/dept/getdept/${item.id}`)}}>Edit</button></td>
                        <td className="col-2"><button  type="button" className="btn btn-danger" onClick={()=>{HandleDelete(item.id)}}>Delete</button></td>
                    </tbody>
                    ))}
            </table>
            </div>
        </div>
    );

}
export default AdminHome;