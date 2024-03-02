import React from 'react';
import { Link } from "react-router-dom";
import axios from "axios";
import { useEffect, useState } from "react";

const AdminHome =() =>{

    const[depts, setDept] = useState([]);

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
            <div className='row'>
                <div className="col">

                </div>
                <div className="col">
                    <button className="btn btn-primary">Add Department</button>
                </div>
            </div>
            
            <table className="col-6 mx-6 my-6 offset-2">
                    <thead>
                        <tr>
                        <th className="col-3">ID</th>
                        <th className="col-3">Department Name</th>
                        </tr>
                    </thead>
                    {depts.map((item) => (
                    <tbody key={item.id}>
                        <td className="col-2">{item.id}</td>
                        <td className="col-4">{item.deptName}</td>
                        <td className="col-3"><button  type="button" className="btn btn-success">Edit</button></td>
                        <td className="col-3"><button  type="button" className="btn btn-danger">Delete</button></td>
                    </tbody>
                    ))}
            </table>
        </div>
    );

}
export default AdminHome;