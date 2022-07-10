import SearchIcon from '@mui/icons-material/Search';
import { Link } from "react-router-dom";

import '../styles/adminPanelHeader.scss';

function AdminPanelHeader(props) {
    return (
        <>
            <div className="admin-panel-header">
                <div className="admin-panel-searchbar">
                    <input type="text" placeholder="search for plans...."></input>
                    <button className="admin-panel-searchButton"><SearchIcon/></button>
                </div>
                <div className="admin-panel-buttons-sect">
                    <Link to="/create-plan"><button className="admin-panel-buttons">Create Plan</button></Link>
                </div>
            </div>
        </>
    )
}

export default AdminPanelHeader;
