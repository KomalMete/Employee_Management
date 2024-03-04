import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './AddDepartment.css'

const AddDepartment =()=>{

    const [name, setName] = useState("");
    const { id } = useParams();
    const [button, setbutton] = useState("Add Product");
    const navigate = useNavigate();

    const init=()=>{
    if(id){
        axios.get(`http://localhost:8080/dept/getdept/${id}`)
        .then((response) => {
            setName(response.data.name);
            setbutton("Confirm");
        })
        .catch((error) => {
            console.log("Something went wrong", error);
          });
    }
    };

    useEffect(() => {
        init();
      }, []);

    const HandleAddDepartment =()=>{
        if(id){
            const department ={
                deptName : name 
            };
            axios.put("http://localhost:8080"+"/dept/edit",department)
            .then((response) => {
                console.log("Printing product data", response.data);
                navigate("/adminhome");
            })
            .catch((error) => {
                console.log("Something went wrong", error);
            });
        }
        else{
            const department ={
                deptName : name 
            };
            axios.post("http://localhost:8080"+"/dept/add",department)
            .then((response) => {
                console.log("Printing product add data", response.data);
                navigate("/adminhome");
            })
            .catch((error) => {
                console.log("Something went wrong", error);
            });
        }
    }

    return(
        <div className="position-absolute top-50 start-50 translate-middle regback">
        <div className="container position-absolute top-50 start-50 translate-middle regform bg-yellow rounded p-4">
          <div className="p-2 text-black fw-bold">
            <h1>Add Department</h1>
            <div className="row">
              <div className="mb-3 col-6 px-5  text-center offset-3">
                <label htmlFor="name" className="form-label">
                  Department Name
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  value={name}
                  onChange={(e) => {
                    setName(e.target.value);
                  }}
                />
              </div>
            
            </div>
            <button
              type="submit"
              className="btn btn-primary"
              onClick={HandleAddDepartment}
            >
              Add Department
            </button>
          </div>
        </div>
      </div>
    );

}
export default AddDepartment;