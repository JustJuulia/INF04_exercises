using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace inf04_akcje_na_plikach
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void plikToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
        string file_name = " ";
        private void otwórzToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "txt files (*txt)|*.txt|(*jpg)|*.jpg|(*png)|*.png";
            if(ofd.ShowDialog() == DialogResult.OK)
            {
                string ext = Path.GetExtension(ofd.FileName);
                if(ext == ".txt")
                {
                    richTextBox1.Text = File.ReadAllText(ofd.FileName);
                }
                else
                {
                    pictureBox1.Load(ofd.FileName);
                }
                file_name = ofd.FileName;
            }
        }

        private void zapiszToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "txt files (*txt)|*.txt";
            if(sfd.ShowDialog() == DialogResult.OK)
            {
                string tekst = richTextBox1.Text;
                File.WriteAllText(sfd.FileName, tekst);

            }
        }

        private void zamknijToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void usuńToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (file_name != "  ")
            {
                File.Delete(file_name);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
