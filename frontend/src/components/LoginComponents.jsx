import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginComponents = () => {
   const [school, setSchool] = useState('');

   const navigate = useNavigate();

   const handleSubmit = async (e) => {
      e.preventDefault();
      try {
         const response = await axios.post('http://localhost:8080/school/login/' + school);
         if (response.status === 200) {
            navigate('/main');
         }
      } catch (error) {
         alert('School not found');
      }
   };

   return (
      <div style={{ maxWidth: '400px', margin: '0 auto', padding: '1rem', border: '1px solid #ccc', borderRadius: '8px' }}>
         <h2>Login</h2>
         <form onSubmit={handleSubmit}>
            <div style={{ marginBottom: '1rem' }}>
               <label htmlFor="email">Colegio:</label>
               <input
                  type="school"
                  id="school"
                  value={school}
                  onChange={(e) => setSchool(e.target.value)}
                  required
                  style={{ width: '100%', padding: '0.5rem', marginTop: '0.5rem' }}
               />
            </div>
            <button type="submit" style={{ width: '100%', padding: '0.5rem', backgroundColor: '#007BFF', color: '#fff', border: 'none', borderRadius: '4px' }}>
               Login
            </button>
         </form>
      </div>
   );
};

export default LoginComponents;