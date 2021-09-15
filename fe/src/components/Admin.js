import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import '../css/content.css';
import Navbar from '../components/Navbar';
import ManageProduct from '../components/SanphamAdmin';
import ManageCategory from '../components/DanhmucAdmin';
import ManageStatistic from '../components/Thongke';

function Admin(){
	return(
		<div>
			<BrowserRouter>
			<div>
				<Navbar />
			</div>
			<div class="noidungAdmin">
		      <Switch>
		      	<Route path="/ProductAdmin" exact component={ManageProduct} />
		        <Route path="/CategoryAdmin" exact component={ManageCategory} />
		        <Route path="/Statistic" exact component={ManageStatistic} />
		      </Switch>
			</div>
			
			</BrowserRouter>
		</div>
	);
}
export default Admin;