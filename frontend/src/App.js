import React from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LoginComponents from "./components/LoginComponents";
import MainComponents from "./components/MainComponents";

function App() {
    return (
        <div>
            <Router>
                <Routes>
                    <Route path="/" element={<LoginComponents />} />
                    <Route path="/main" element={<MainComponents />} />
                </Routes>
            </Router>
        </div>
    );
}

export default App;