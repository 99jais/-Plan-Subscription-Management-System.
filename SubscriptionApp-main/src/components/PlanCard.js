import { Link } from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux';
import { deletePlan } from '../actions/planActions';
import {
    useParams,
    useNavigate,
    useLocation,
  } from "react-router-dom";

import '../styles/plancard.scss';

function PlanCard(props) {

    let dispatch = useDispatch();

    function handlePlanDelete() {
        window.confirm("Are u sure, u want to delete plan with ID:" + props.planDetails.plan_id);
        dispatch(deletePlan(props.planDetails.plan_id));
    }

    return (
        <>
            <div className="plan-card-main">
                <div className="plan-card-header">
                    <h3>{props.planDetails.name}</h3>
                </div>
                <div className="plan-card-desc">
                    {props.planDetails.description.substring(0,50)}...
                </div>
                <div className="plan-card-footer">
                    <div className="plan-card-dates">
                        {props.planDetails.valid_from} - {props.planDetails.valid_to}
                    </div>
                    <div className="plan-card-price">
                        ${props.planDetails.price}
                    </div>
                </div>
                <div className="plan-card-buttons-sect">
                    <Link to={`/plan-details/${props.planDetails.plan_id}`}><button className="plan-card-buttons">View</button></Link>
                    <Link to={`/edit/${props.planDetails.plan_id}`}><button className="plan-card-buttons">Edit</button></Link>
                    <button className="plan-card-buttons" onClick={handlePlanDelete}>Delete</button>
                </div>
            </div>
        </>
    )
}

export default PlanCard;
