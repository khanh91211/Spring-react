import React,{useState} from 'react';
import {Link} from 'react-router-dom';
import '../css/navbar.css';
import BarChartIcon from '@material-ui/icons/BarChart';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import CategoryIcon from '@material-ui/icons/Category';
import GridOnIcon from '@material-ui/icons/GridOn';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import { IconContext } from 'react-icons';


const NavbarData = [
  {
    title:'Statistic',
    path:'/Statistic',
    icon:<BarChartIcon/>,
    cName:'nav-text',
  },
  {
    title:'Product',
    path:'/ProductAdmin',
    icon:<GridOnIcon/>,
    cName:'nav-text',
  },
  {
    title:'Catagory',
    path:'/CategoryAdmin',
    icon:<CategoryIcon/>,
    cName:'nav-text',
  },
  {
    title:'Account',
    icon:<AccountCircleIcon/>,
    cName:'nav-text',
  },
  {
    title:'Log out',
    path:'/Dangnhap',
    icon:<ExitToAppIcon/>,
    cName:'nav-text',
  },
]

function Navbar () {

  const [navbar,setNavbar] = useState(true);

  const showNavbar = () =>setNavbar(navbar);
  return (
    <>
    <IconContext.Provider value={{color:'#fff'}}>
      <div> 
        <div className='navbarRight'>
        </div>
      </div>
      <nav className={navbar ? 'nav-menu active' : 'nav-menu'}>
        <ul className='nav-menu-items' >
          <div>
            <Link to="#" className='menu-name'>SHOPKHANH</Link>
            <hr class="taghr"/>
          </div>
          {NavbarData.map((item,index)=>{
            return(
              <li key={index} className={item.cName}>
                <Link to={item.path}>
                  {item.icon}
                  <span>{item.title}</span>
                </Link>
              </li>
              )
          })}
        </ul>
      </nav>
    </IconContext.Provider>
    </>
  );
}

export default Navbar;