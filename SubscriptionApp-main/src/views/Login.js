import '../styles/authForms.scss';

function Login(props) {
    return (
        <>
            <div className="auth-form-main">
                <div className="form-main">
                    <div className="form-header">
                        <h2>Login</h2>
                    </div>
                    <div className="form-fields-div">
                        <input type="text" className="form-text-field" name="username" placeholder="username"/>
                        <input type="password" className="form-text-field" name="password" placeholder="password"/>
                    </div>
                    <div className="form-button-div">
                        <button>Login</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Login;