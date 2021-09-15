import DeleteForeverIcon from '@material-ui/icons/DeleteForever';
import React from 'react';
import axios from 'axios';
import { useState  } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table';
import SearchIcon from '@material-ui/icons/Search';


function ListProduct({
  data,
  setClickedRow,
  setFormData,
  setProducts,
}) {
  const tblOnClickHandler = function (event, value, index) {
    setClickedRow(index);
    setFormData(value);
  }

  const btnDeleteOnClick = (event, value,index) => {
    // setProducts((oldState) => {
    //   let newState = oldState.filter((value, idx) => {
    //     return idx == index ? false : true;
    //   });
    //   return newState;
    // });

    const urlApiXoa = 'http://localhost:8080/api/product/' + value.id;
    axios.delete(urlApiXoa)
      .then(function(response){
        const listNew=data.filter(function(val,idx){
          if(idx == index){
            return false;
          }else{
            return true;
          }
        });

        setProducts(listNew)
      })
      .catch(function (error){
        console.error('error');
      });
  }

    const [input,setInput]=useState("");

    const handleChange=(e) =>{
      e.preventDefault();
      setInput(e.target.value);
    };

    if(input.length>0){
      data=data.filter((i)=>{
        return i.name.toLowerCase().match(input);
      });
    }

  return (
    <React.Fragment>
    <div className="">
      <SearchIcon style={{color:'gray',float: 'left'}}/>
      <input
          id="nhapSearch"
          type="text"
          placeholder="Search name"
          onChange={handleChange}
          value={input}
          style={{float: 'left',color:'gray'}}/>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Image</th>
            <th>Price</th>
            <th>Category</th>
            <th>Remove</th>
          </tr>
        </thead>
        <tbody>
        {data.map(function (value, index) {
          return (
          <tr onClick={
              (event) => tblOnClickHandler(event, value, index) }key={index}>
            <td>{value.id}</td>
            <td>{value.name}</td>
            <td><img src='../images/{value.image}'/></td>
            <td>{value.price}</td>
            <td>{value.categoryId.name}</td>
            <td>
              <button  onClick={ (event) => {
              btnDeleteOnClick(event, value, index)
              } }><DeleteForeverIcon/></button>
            </td>
          </tr>
          )})}
        </tbody>
      </Table>
      </div>
    </React.Fragment>

  );
}

export default ListProduct;