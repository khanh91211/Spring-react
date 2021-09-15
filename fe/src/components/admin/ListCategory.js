import DeleteForeverIcon from '@material-ui/icons/DeleteForever';
import React from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table'

function ListCategory({
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

    const urlApiXoa = 'http://localhost:8080/api/category/' + value.id;
    axios.delete(urlApiXoa)
      .then(function(response){
        const listNew=data.filter(function(val,idx){
          if(idx == index){
            //loại bỏ phần tử
            return false;
          }else{
            //giữ lại phần tử
            return true;
          }
        });

        setProducts(listNew)
      })
      .catch(function (error){
        console.error('error');
      });
  }


  return (
    <React.Fragment>
    <div className="">
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name category</th>
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
            <td>
              <button onClick={ (event) => {
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

export default ListCategory;