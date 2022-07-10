import '../styles/authForms.scss';

function SignUp(props) {
    return (
        <>
            <div className="auth-form-main">
                <div className="form-main">
                    <div className="form-header">
                        <h3>Register</h3>
                    </div>
                    <div className="form-fields-div">
                        <input type="text" className="form-text-field" name="username" placeholder="username"/>
                        <input type="email" className="form-text-field" name="email" placeholder="email"/>
                        <input type="text" className="form-text-field" name="firstname" placeholder="firstname"/>
                        <input type="text" className="form-text-field" name="lastname" placeholder="lastname"/>
                        <input type="tel" className="form-text-field" name="phone" placeholder="mobile no."/>
                        <input type="password" className="form-text-field" name="password" placeholder="password"/>
                    </div>
                    <div className="form-button-div">
                        <button>Register</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default SignUp;