import plans from "./rawData";

const initialState = {
    plans: plans,
    users: []
};

const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case "CREATE_PLAN":
            return {
                ...state,
                plans: [action.payload.planDetails,...state.plans]
            }
        case "EDIT_PLAN":
            return Object.assign({}, state, {
                plans: state.plans.map((plan) => {
                    if(action.payload.planId == plan.plan_id) {
                        return Object.assign({}, plan, {
                            name: action.payload.planDetails.name,
                            description: action.payload.planDetails.description,
                            valid_from: action.payload.planDetails.valid_from,
                            valid_to: action.payload.planDetails.valid_to,
                            price: action.payload.planDetails.price
                        })
                    }
                    return plan;
                })
            })
        case "DELETE_PLAN":
            return Object.assign({}, state, {
                plans: state.plans.filter((plan) => {
                    return action.payload.planId != plan.plan_id
                })
            })
        default:
            return state;
    }
}

export default mainReducer;
