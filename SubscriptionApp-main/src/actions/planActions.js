export const createPlan = (planDetails) => {
    return {
        type: "CREATE_PLAN",
        payload: {
            planDetails: planDetails
        }
    }
}

export const editPlan = (planId, newPlanDetails) => {
    return {
        type: "EDIT_PLAN",
        payload: {
            planId: planId,
            planDetails: newPlanDetails
        }
    }
}

export const deletePlan = (planId) => {
    return {
        type: "DELETE_PLAN",
        payload: {
            planId: planId
        }
    }
}
