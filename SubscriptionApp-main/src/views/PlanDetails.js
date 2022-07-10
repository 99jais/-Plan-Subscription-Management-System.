import { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { useParams } from "react-router-dom";

import '../styles/planDetails.scss';

function PlanDetails(props) {
    let params = useParams();

    const [planDetails, setPlanDetails] = useState({});

    const plans = useSelector(state => state.plans);
    const dispatch = useDispatch();

    useEffect(() => {
        if(plans.length > 0 && plans !== undefined) {
            setPlanDetails(plans.find((plan) => plan.plan_id == params.planId));
        }
    });

    return (
        <div className="planDetails-main">
            <div>
                <h1>{planDetails.name}</h1>
            </div>
            <div>
                {planDetails.description}
            </div>
            <div>
                {planDetails.valid_from} - {planDetails.valid_to}
            </div>
            <div>
                ${planDetails.price}
            </div>
        </div>
    )
}

export default PlanDetails;
