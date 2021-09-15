import React from 'react';
import '../css/login.css';
import {Link} from 'react-router-dom';


function Dangnhap(){
	return(
		<div className="body">
	  	<div className="title"><h1>LOGIN</h1></div>
	  	<div className="container">
	  		<div className="left"></div>
	  		<div className="right"> 
				<div className="formLogin">			
						<h5>Username</h5>
					<input type="text" name="" placeholder="Username"/>
						<h5>Password</h5>
					<input type="Password" name="" placeholder="********"/>
						<br/><br/>
					<Link to="/Admin">
		  				<button type="submit">Submit</button>
		  			</Link>
		  			<Link to="/Dangky">                                                                                    
		  				<p>Don't have an account? Create</p>                                                              
		  			</Link>
				</div>
			</div>
	  	</div>
  		</div>
	);
}

export default Dangnhap;