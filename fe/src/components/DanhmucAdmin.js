import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import Typography from '@material-ui/core/Typography';
import ListCategory from '../components/admin/ListCategory';
import CreateCategory from '../components/admin/CreateCategory';
import Grid from '@material-ui/core/Grid';
import Backdrop from '@material-ui/core/Backdrop';
import CircularProgress from '@material-ui/core/CircularProgress';
import { useState ,useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import ArrowLeftIcon from '@material-ui/icons/ArrowLeft';
import ArrowRightIcon from '@material-ui/icons/ArrowRight';




function DanhmucAdmin() {

  const formDataInitValue = {
    id: '',
    name: '',
  }

  const [loading, setLoading] = useState(false);
  const [products, setProducts] = useState([]);
  const [clickedRow, setClickedRow] = useState(-1);
  const [formData, setFormData] = useState(formDataInitValue);
  const [limit, setLimit] = useState(5);
  const [page, setPage] = useState(1);

  useEffect(() => {
    setLoading(true);
    const url = "http://localhost:8080/api/category?limit=" + limit + "&page=" + page;
    axios({
      method: 'GET',
      url: url,
    })
      .then((response) => {
        setLoading(false);
        const { data } = response;
        setProducts(data);
      })
      .catch((error) => {
        console.log(error, error.response);
        setLoading(false);
      });
    }, [
      page,
  ]);


  const trangTruoc = function () {
    if (page == 1) {
      return ;
    }

    setPage(page - 1);
  }

  const trangSau = function () {
      setPage(page + 1);
    
  }


  return (
    <div className="">
    <h4 style={{fontWeight:'bold',textAlign:'left'}}>Category</h4>
      <div>
        <CssBaseline />
        <Container maxWidth="sm" className="">
          <Backdrop
            style={{ zIndex: '1000', marginLeft:'0'}}
            open={ loading }>
            <CircularProgress />
          </Backdrop>
          <Typography component="div" style={{height: '100vh' }}>
            <Grid container>
              <Grid item>
                <CreateCategory
                  setFormData={ setFormData }
                  setProducts={ setProducts }
                  products={ products }
                  formData={ formData }
                  clickedRow={ clickedRow }/>
              </Grid>
              <Grid item>
              </Grid>
            </Grid>
            <ListCategory
              setProducts={ setProducts }
              setFormData={setFormData}
              setClickedRow={setClickedRow}
              data={products} />
            <div className="">
            <ul className="pagination mt-4">
              <li
                onClick={ trangTruoc }
                className="page-item" >
                <a className="page-link" style={{color:'black'}}><ArrowLeftIcon/></a>
              </li>

              <li className="page-item">
                <a className="page-link" style={{color:'black'}}>{ page }</a>
              </li>

              <li
                onClick={ trangSau }
                className="page-item">
                <a className="page-link" style={{color:'black'}}><ArrowRightIcon/></a>
              </li>
            </ul>
            </div>
          </Typography>
        </Container>
      </div>
    </div>
  );
}

export default DanhmucAdmin;

