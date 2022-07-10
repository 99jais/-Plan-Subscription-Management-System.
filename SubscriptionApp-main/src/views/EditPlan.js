import { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { editPlan } from '../actions/planActions';
import {
    useParams,
    useNavigate,
    useLocation,
  } from "react-router-dom";

import '../styles/authForms.scss';
import PlanDetails from './PlanDetails';

function EditPlan(props) {

    const plans = useSelector(state => state.plans);
    const dispatch = useDispatch();

    const [planName, setPlanName] = useState('');
    const [planDesc, setPlanDesc] = useState('');
    const [planValidFrom, setPlanValidFrom] = useState('');
    const [planValidTo, setPlanValidTo] = useState('');
    const [planPrice, setPlanPrice] = useState('');

    let params = useParams();
    let navigate = useNavigate();

    useEffect(() => {
        var planDetail = plans.find((plan) => plan.plan_id == params.planId);
        setPlanName(planDetail.name);
        setPlanDesc(planDetail.description);
        setPlanValidFrom(planDetail.valid_from);
        setPlanValidTo(planDetail.valid_to);
        setPlanPrice(planDetail.price);
    }, [])

    function handleCreatePlan() {
        let newPlanDetails = {
            name: planName,
            description: planDesc,
            valid_from: planValidFrom,
            valid_to: planValidTo,
            price: planPrice
        };
        console.log("newPlanDetails >> ", newPlanDetails);
        dispatch(editPlan(params.planId,newPlanDetails));
        navigate("/admin");
    }

    return (
        <>
            <div className="auth-form-main">
                <div className="form-main">
                    <div className="form-header">
                        <h3>EDIT PLAN</h3>
                    </div>
                    <div className="form-fields-div">
                        <input type="text" 
                            className="form-text-field" 
                            name="name" placeholder="name" 
                            value={planName} 
                            onChange={(e) => setPlanName(e.target.value)} 
                        />
                        <textarea 
                            className="form-text-field" 
                            rows="5" name="description" 
                            placeholder="description" 
                            value={planDesc} 
                            onChange={(e) => setPlanDesc(e.target.value)} 
                        />
                        <input type="date" 
                            className="form-text-field" 
                            name="valid_from" placeholder="valid from" 
                            value={planValidFrom} 
                            onChange={(e) => setPlanValidFrom(e.target.value)} 
                        />
                        <input type="date" 
                            className="form-text-field" 
                            name="valid_to" placeholder="valid to" 
                            value={planValidTo} 
                            onChange={(e) => setPlanValidTo(e.target.value)} 
                        />
                        <input type="number" 
                            className="form-text-field" 
                            name="price" placeholder="price" 
                            value={planPrice} 
                            onChange={(e) => setPlanPrice(e.target.value)} 
                        />
                    </div>
                    <div className="form-button-div">
                        <button onClick={handleCreatePlan}>EDIT PLAN</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default EditPlan;