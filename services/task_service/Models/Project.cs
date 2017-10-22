using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Tasks.Models
{
    public class Project
    {
        [Key]
        public int Id { get; set; }

        public string Owner { get; set; }
        public string Name { get; set; }
    }
}