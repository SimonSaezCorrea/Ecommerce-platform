import React, { useEffect, useState } from "react";
import styled from "styled-components";

const MainComponents = () => {

   const [courses, setCourses] = useState([]);

   useEffect(() => {
      const fetchCourses = async () => {
         try {
            const response = await fetch('http://localhost:8080/course/');
            const data = await response.json();
            console.log(data)
            setCourses(data);
         } catch (error) {
            console.error('Error fetching courses:', error);
         }
      };

      fetchCourses();
   }, []);

   return (
      <NavStyle>
         <div className="container">
            <aside className="sidemenu">
               <ul>
                  <li><a href="#home">Home</a></li>
                  <li><a href="#services">Services</a></li>
                  <li><a href="#contact">Contact</a></li>
               </ul>
            </aside>
            <main className="main-content">
               <h1>Welcome to the Main Component</h1>
               <p>This is the main content area.</p>
               <table className='table-content'>
                  <thead>
                     <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Professor ID</th>
                        <th>School ID</th>
                     </tr>
                  </thead>
                  <tbody>
                     {courses.length > 0 ? courses.map(course => (
                        <tr key={course.id}>
                           <td>{course.id}</td>
                           <td>{course.name}</td>
                           <td>{course.description}</td>
                           <td>{course.id_professor}</td>
                           <td>{course.id_school}</td>
                        </tr>
                     )) : <tr><td colSpan="5">No courses</td></tr>}
                  </tbody>
               </table>
            </main>
         </div>
      </NavStyle>
   );
};

export default MainComponents;


const NavStyle = styled.nav`

.container {
   display: flex;
}

.sidemenu {
   width: 200px;
   background-color: #f4f4f4;
   padding: 15px;
}

.sidemenu ul {
   list-style-type: none;
   padding: 0;
}

.sidemenu ul li {
   margin: 10px 0;
}

.sidemenu ul li a {
   text-decoration: none;
   color: #333;
}

.main-content {
   flex-grow: 1;
   padding: 20px;
}
.sidemenu ul li a:hover {
   color: #007BFF;
}

.main-content h1 {
   font-size: 2em;
   margin-bottom: 10px;
}

.main-content p {
   font-size: 1.2em;
   line-height: 1.6;
}
   
.table-content {
   width: 100%;
   border-collapse: collapse;
}

.table-content th {
   background-color: #007BFF;
   color: white;
   font-size: 1.2em;
}

.table-content th, .table-content td {
   padding: 10px;
   border: 1px solid #ccc;
}

.table-content tr:nth-child(even) {
   background-color: #f4f4f4;
}

.table-content tr:hover {
   background-color: #2fffff;
}
`