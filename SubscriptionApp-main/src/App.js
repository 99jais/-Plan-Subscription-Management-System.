import { Route, Routes } from 'react-router-dom';
import Login from './views/Login';
import SignUp from './views/SignUp';
import Admin from './views/Admin';
import User from './views/User';
import CreatePlan from './views/CreatePlan';
import EditPlan from './views/EditPlan';
import PlanDetails from './views/PlanDetails';



import './App.scss';

function App() {
  return (
    <div className="App">
      
      <Routes>
        <Route path="/" element={<Login />}/>
        <Route path="/sign-up" element={<SignUp />}/>
        <Route path="/admin" element={<Admin />}/>
        <Route path="/user" element={<User />}/>
        <Route path="/create-plan" element={<CreatePlan />}/>
        <Route path="/edit/:planId" element={<EditPlan />}/>
        <Route path="/plan-details/:planId" element={<PlanDetails />}/>
      </Routes>
    
    </div>
  );
}

export default App;
