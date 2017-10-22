using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Main.Entities
{
    public enum Job { Developer, ProjectManager, Tester }

    public class AspNetUserRoles
    {
        [Key]
        public string UserId { get; set; }
        public string RoleId { get; set; }
    }
}