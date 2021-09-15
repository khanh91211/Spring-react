import axios from 'axios';
import { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dropdown from 'react-bootstrap/Dropdown';
import SanphamAdmin from '../components/SanphamAdmin';
import CreateProduct from '../components/admin/CreateProduct';

function DmucSphamAdmin () {

  const formDataInitValue = {
    id: '',
    name: '',
    image:'',
    price: '',
    createdate: '',
    available: '',
    categoryid: '',
  }

  const apiListCategory = 'http://localhost:8080/api/category';
  const [listDanhMuc, setListDanhMuc] = useState([]);
  const [id, setId] = useState(-1);
  // const [loading, setLoading] = useState(false);
  // const [products, setProducts] = useState([]);
  // const [clickedRow, setClickedRow] = useState(-1);
  // const [formData, setFormData] = useState(formDataInitValue);
  // const [limit, setLimit] = useState(5);
  // const [page, setPage] = useState(1);

  useEffect(() => {
    axios.get(apiListCategory)
      .then(function (response) {
        const { data } = response;
        setListDanhMuc(data);
        // <SanphamAdmin dataProducts={data.length}/>
        // console.log(data);
      })
      .catch(function (error) {
        console.log(error);
      });

  }, [
  ]);

  const onClickDanhMuc = function (event, danhMuc) {
    setId(danhMuc.id);
  }

  return (
    <div>
      <div style={{textAlign:'left'}}>
      <h4 style={{fontWeight:'bold',}}>Category</h4>
      <tr>
        <Dropdown>
          <Dropdown.Toggle variant="success" id="dropdown-basic">
            Category
          </Dropdown.Toggle>
          <Dropdown.Menu>
          {
            listDanhMuc.map((danhMuc, index) => {
              return (
               <Dropdown.Item onClick={
                    (event) => {
                      onClickDanhMuc(event, danhMuc);
                    }
                  }
                  key={ index }>{danhMuc.name }</Dropdown.Item>
                  );
                })}
            </Dropdown.Menu>
        </Dropdown>
        </tr>
        <ul >
          <div className="col-8">
            <SanphamAdmin
            danhMucId={ id }/>
          </div>
        </ul>
      </div>
    </div>
  );
}

export default DmucSphamAdmin;