import TextField from '@material-ui/core/TextField';
import Container from '@material-ui/core/Container';
import Button from '@material-ui/core/Button';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dropdown from 'react-bootstrap/Dropdown';
import MenuItem from '@material-ui/core/MenuItem';

function CreateProduct({ clickedRow,formData ,setFormData,setProducts,products}) {
  // const[id,setId]=useState(clickedRow.id);

  const onChangeHandler=(event)=>{
    const{name,value}=event.target;
    setFormData({
      ...formData,
      [name]:value,
    });
  }

  const onUpdateProduct = function(){
    const updateApiUrl='http://localhost:8080/api/product/'+formData.id;
    
    axios.put(updateApiUrl,formData)
    .then(function (response){
      const {data} = response;
      console.log(data);
      const listProductNew=products.map(function (val,idx){
        if(val.id==data.id ){
          return data;
        }else{
          return val;
        }
      });
      setProducts(listProductNew);
    })
    .catch(function(error){
      console.log(error);
    })
  }

  const onSubmitHandler=(event)=>{
    event.preventDefault();
    if(clickedRow!=-1){
      //update row
      onUpdateProduct();
    }else{
      //add 1 row new
      onCreateProduct();
    }
  }
  
  const onCreateProduct=()=>{
    
    const url='http://localhost:8080/api/product/'+formData.id;
    axios({
      method:'POST',
      url:url,
      data: formData,
    })
      .then((response)=>{
        const {data}=response
        setProducts([
          ...products,//'...' đưa toàn bộ phần tử của product vào
          data,
        ]);
      }).catch((error)=>{
        console.log(error);
      });
  }

  
  return (
    <Container mb={5} style={{textAlign:'center',background:'white'}}>
      <form 
        onSubmit={onSubmitHandler}
        autoComplete="off">

        <TextField 
          value={formData.id} 
          onChange={onChangeHandler}
          variant="outlined"
          name="id"
          fullWidth
          disabled
          style={{marginTop: '20px'}}
          label="Mã"/>

          
        <TextField 
          value={formData.name} 
          onChange={onChangeHandler}
          variant="outlined"
          name="name"
          fullWidth
          style={{marginTop: '20px'}}
          label="Tên sản phẩm"/>

       <TextField 
          value={formData.price} 
          onChange={onChangeHandler}
          variant="outlined"
          name="price"
          fullWidth
          style={{marginTop: '20px'}}
          label="Giá"/>

        <Button
          variant="contained"
          type="submit"
          style={{ marginTop: '10px', background:'black',color:'white', marginBottom:'10px', paddingLeft:'5px'}}>
          Submit
        </Button>
      </form>
    </Container>
  );
}

export default CreateProduct;