import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { createPlan } from '../actions/planActions';
import PlanCard from '../components/PlanCard';
import AdminPanelHeader from '../components/AdminPanelHeader';
// import ReactPaginate from 'react-paginate';
import Paginator from '../components/Paginator';

import '../styles/admin.scss';



function Admin(props) {
    const plans = useSelector(state => state.plans);
    const dispatch = useDispatch();
    const planDetails = {
        name: 'new scheme',
        price: '2000'
    };

    console.log(plans);

    const planCardsList = plans.map((planDetails) => <PlanCard planDetails={planDetails}/>)

    return (
        <>
            <div className="admin-panel-main">
                <div className="admin-panel-title">
                    <h1>ADMIN PANEL</h1>
                </div>
                <AdminPanelHeader />
                <div className="admin-panel-cards-sect">
                    <Paginator itemsPerPage={8} />
                </div>
            </div>
        </>
    )
}

export default Admin;